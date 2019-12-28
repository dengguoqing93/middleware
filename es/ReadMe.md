## 关于es学习笔记

#### es的安装与启动

系统：centos7，jdk：1.8

1. **下载elasticsearch：** 下载地址：[es下载](http://www.elastic.co/downloads/elasticsearch%5D)
   下载tar格式
2. 解压tar。由于5.0开始，ElasticSearch 安全级别提高了，不允许采用root帐号启动，所以我们要添加一个用户。并更改解压文件属组和文件夹权限
3. 创建用户组，用户以及变更文件夹权限的命令如下：

    groupadd es ##创建用户组
    useradd es -g es -p 123456 ##创建用户，-e代表把es用户分配到es用户组中，-p代表给es用户设置密码为123456：
    chown -R es:es /opt/es ##修改权限，更改elasticsearch文件夹以及内部文件的所属用户以及组为es，-R表示逐级

4. 进入到elasticsearch安装目录的bin目录下
       `$ cd /usr/local/elasticsearch/bin`
      执行运行操作，-d表示后台运行
       `$ ./elasticsearch -d`
     查看是否运行成功：
      `$ curl http://localhost:9200`

#### 基础配置

   elasticsearch的主配置文件在config/elasticsearch.yml中，该配置文件包含集群、节点、网络和数据存储等等的重要配置。

```yaml
################################## 集群相关配置 ################################### 
# cluster.name可以确定你的集群名称,当你的elasticsearch集群在同一个网段中elasticsearch会自动的找到具有相同cluster.name的elasticsearch服务. 
# 所以当同一个网段具有多个elasticsearch集群时cluster.name就成为同一个集群的标识.，可以手动指定也可以自动生成
# cluster.name: elasticsearch 

#################################### 节点相关配置 ##################################### 
# 节点名称同理,可自动生成也可手动配置. 
# node.name: node-1

# 允许一个节点是否可以成为一个master节点,es是默认集群中的第一台机器为master,如果这台机器停止就会重新选举master. 
# node.master: true 

# 允许该节点存储数据(默认开启) 
# node.data: true 

# 默认情况下，多个节点可以在同一个安装路径启动，如果你想让你的es只启动一个节点，可以进行如下设置
# node.max_local_storage_nodes: 1 

#################################### 索引相关配置 #################################### 
# 设置索引的分片数,默认为5 
#index.number_of_shards: 5 

# 设置索引的副本数,默认为1: 
#index.number_of_replicas: 1 

# 配置文件中提到的最佳实践是,如果服务器够多,可以将分片提高,尽量将数据平均分布到大集群中去
# 同时,如果增加副本数量可以有效的提高搜索性能 
# 需要注意的是,"number_of_shards" 是索引创建后一次生成的,后续不可更改设置 
# "number_of_replicas" 是可以通过API去实时修改设置的 

#################################### 路径相关配置 #################################### 
# 配置文件存储位置 
# path.conf: /path/to/config 

# 数据存储位置(单个目录设置) 
# path.data: /path/to/data 
# 多个数据存储位置,有利于性能提升 
# path.data: /path/to/data1,/path/to/data2 

# 临时文件的路径 
# path.work: /path/to/work 

# 日志文件的路径 
# path.logs: /path/to/logs 

# 插件安装路径 
# path.plugins: /path/to/plugins 


################################### 内存相关配置 #################################### 
# 当JVM开始写入交换空间时（swapping）ElasticSearch性能会低下,你应该保证它不会写入交换空间 
# 设置这个属性为true来锁定内存,同时也要允许elasticsearch的进程可以锁住内存,linux下可以通过 `ulimit -l unlimited` 命令 
# bootstrap.mlockall: true 
# 确保 ES_MIN_MEM 和 ES_MAX_MEM 环境变量设置为相同的值,以及机器有足够的内存分配给Elasticsearch 
# 注意:内存也不是越大越好,一般64位机器,最大分配内存别才超过32G 

############################## 网络相关配置 ############################### 
# 设置绑定的ip地址,可以是ipv4或ipv6的，默认绑定本机ip
# network.bind_host: 192.168.0.1  

# 设置其它节点和该节点交互的ip地址,如果不设置它会自动设置,值必须是个真实的ip地址 
# network.publish_host: 192.168.0.1 

# 同时设置bind_host和publish_host上面两个参数 
# network.host: 192.168.0.1    #绑定监听IP

# 设置节点间交互的tcp端口,默认是9300 
# transport.tcp.port: 9300 

# 设置是否压缩tcp传输时的数据，默认为false,不压缩
# transport.tcp.compress: true 

# 设置对外服务的http端口,默认为9200 
# http.port: 9200 

# 设置请求内容的最大容量,默认100mb 
# http.max_content_length: 100mb 

# 使用http协议对外提供服务,默认为true,开启 
# http.enabled: false 
```


#### 取消主机限制
   接下来我们具体来配置一下，让elasticsearch服务能够给外部IP访问：
       首先我们通过刚刚的基础配置发现，网络相关配置中有3个配置项是跟IP有关的：network.bind_host、network.publish_host和network.host，他们的用法分别是：
**network.bind_host：**
       在默认情况下elasticsearch服务只能本机访问，如果外部主机需要访问该elasticsearch服务，就需要把外部的这台主机的IP配置到该属性中。那如果希望elasticsearch服务不限制所有主机的访问，那么该属性可以设置为0.0.0.0。

**network.publish_host：**
       在默认情况下elasticsearch的节点不能跨主机交互，如果需要，则在该属性配置elasticsearch节点服务所在的IP。那如果希望elasticsearch服务不限制所有主机的节点交互，那么该属性可以配置为0.0.0.0。

**network.host：**
       同时设置bind_host和publish_host两个参数，那我们只需要把该属性设置为0.0.0.0，那么就不限制主机的访问和节点的交互

那么我们就来修改elasticsearch的配置文件：
`$ vi config/elasticsearch.yml`
找到network.host这行配置，把注释解开，值设置为0.0.0.0
`$ network.host: 0.0.0.0`
退出并保存elasticsearch.yml文件，然后重启elasticsearch服务
关闭elasticsearch服务：
`使用强制杀进程的方式关闭elasticsearch`


## 解决问题
### 问题1：
max file descriptors [4096] for elasticsearch process likely too low, increase to at least [65536]

max number of threads [1024] for user [lishang] likely too low, increase to at least [2048]


切换到root用户，编辑limits.conf 添加类似如下内容
 vi /etc/security/limits.conf

添加如下内容:

* soft nofile 65536

* hard nofile 131072

* soft nproc 2048

* hard nproc 4096
重新连接用户即可

### 问题2：
max virtual memory areas vm.max_map_count [65530] likely too low, increase to at least [262144]


切换到root用户修改配置sysctl.conf

vm.max_map_count=655360

并执行命令：

sysctl -p

然后，重新启动elasticsearch，即可启动成功。

       至此，我们已经把elasticsearch的服务取消的主机访问的限制了，但是我们还是不能通过外部的主机访问elasticsearch服务，因为我们系统的防火墙是开启的，我们需要把elasticsearch服务的网络端口放开，这样才能让外界访问。我们通过地址访问elasticsearch服务：[http://IP:9200](http://IP:9200)可以知道它的http网络端口为9200，并且我们刚刚学习的配置我们发现，网络相关配置中有个http.port属性，该属性是配置elasticsearch的http端口的，默认端口为9200，所以我们需要把9200端口放开：
`$ firewall-cmd --zone=public --add-port=9200/tcp --permanent #--permanent永久生效，没有此参数重启后失效`
重新加载防火墙：
`$ firewall-cmd --reload`


1.  wget https://artifacts.elastic.co/downloads/kibana/kibana-6.6.2-linux-x86_64.tar.gz
