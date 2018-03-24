package Decoding;

import sun.misc.BASE64Decoder;
import java.io.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by 1 on 24.03.2018.
 */
public class DecodeMethod {
    private static final Logger LOGGER = LogManager.getLogger(DecodeMethod.class.getName());

    public static void decode() throws FileNotFoundException {
        byte[] bytes = new byte[5000];
        try {
            FileInputStream fis = new FileInputStream(new File("enc.txt"));
            BASE64Decoder decoder = new BASE64Decoder();
            bytes = decoder.decodeBuffer(fis);
            fis.close();

            StringBuilder msg = new StringBuilder();
            msg.append("Successful write to byte []");
            LOGGER.info(msg);
        } catch (IOException e) {
            StringBuilder msg = new StringBuilder();
            msg.append("Can't read file and write to byte []");
            LOGGER.error(msg);
        }

        try {
            FileOutputStream fos = new FileOutputStream("pic.jpg");
            fos.write(bytes);
            fos.flush();
            fos.close();

            StringBuilder msg = new StringBuilder();
            msg.append("Successful write byte [] to file");
            LOGGER.info(msg);
        } catch (IOException e) {
            StringBuilder msg = new StringBuilder();
            msg.append("Can't write byte [] to file");
            LOGGER.error(msg);
        }
    }
}
