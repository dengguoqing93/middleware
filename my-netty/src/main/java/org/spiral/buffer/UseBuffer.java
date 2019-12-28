package org.spiral.buffer;

import java.nio.IntBuffer;

/**
 * 使用netty的buffer
 *
 * @author dengguoqing
 * @date 2019/12/27
 * @copyright spiral
 * @since 1.0 Version
 */
public class UseBuffer {
    static IntBuffer intBuffer = null;

    public static void main(String[] args) {
        intBuffer = IntBuffer.allocate(20);
        for (int i = 0; i < 5; i++) {
            intBuffer.put(i);
        }
        intBuffer.flip();
        System.out.println("---after allocate----");
        System.out.println("position = " + intBuffer.position());
        System.out.println("limit = " + intBuffer.limit());
        System.out.println("capacity = " + intBuffer.capacity());

    }
}
