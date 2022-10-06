/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GerenciadorIO {
    public GerenciadorIO() {
    }

    public static String getProperties(String nome) {
        Properties defaultProps = new Properties();

        try {
            FileInputStream in = new FileInputStream("./config/config.properties");
            defaultProps.load(in);
            in.close();
        } catch (FileNotFoundException var4) {
            Logger.getLogger(GerenciadorIO.class.getName()).log(Level.SEVERE, (String)null, var4);
        } catch (IOException var5) {
            Logger.getLogger(GerenciadorIO.class.getName()).log(Level.SEVERE, (String)null, var5);
        }

        String propriedade = defaultProps.getProperty(nome);
        return propriedade;
    }

    public static void getPropriedades(String properties, String Valor) {
        File file = new File("./config/config.properties");
        Properties properties1 = new Properties();

        try {
            FileInputStream inputStream = new FileInputStream(file);
            properties1.load(inputStream);
        } catch (IOException var17) {
            var17.printStackTrace();
        }

        properties1.setProperty(properties, Valor);

        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            Throwable var5 = null;

            try {
                properties1.store(outputStream, (String)null);
            } catch (Throwable var16) {
                var5 = var16;
                throw var16;
            } finally {
                if (outputStream != null) {
                    if (var5 != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable var15) {
                            var5.addSuppressed(var15);
                        }
                    } else {
                        outputStream.close();
                    }
                }

            }
        } catch (IOException var19) {
            var19.printStackTrace();
        }

    }
}

