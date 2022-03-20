package com.cjy.file

import javazoom.jl.decoder.Bitstream
import java.io.InputStream

class FileUtil {

    companion object {
        @JvmStatic
        fun getAudioDuration(input: InputStream, length: Int) = Bitstream(input).readFrame().total_ms(length)
    }
}