package com.yjq.parser.utils;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yang Jianqiang
 * @date 2021/12/21
 */
public class YmlUtils {
    public static String config = "config.yml";

    public static Map<Object, Object> readConfig() {
        Yaml yml = null;
        Map<Object, Object> obj = new HashMap<>();
        URL url = YmlUtils.class.getClassLoader().getResource(config);
        if (url != null) {
            try (FileInputStream in = new FileInputStream(url.getFile())) {
                yml = new Yaml();
                obj = yml.load(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return obj;
        }else {
            return null;
        }
    }
}
