package cn.mrcsh.bukkitwebframework.Bungee.Utils;

import cn.mrcsh.bukkitwebframework.Bungee.Config.WebConfig;
import com.google.common.io.ByteStreams;
import lombok.SneakyThrows;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;

public class ConfigYmlUtil {

    @SneakyThrows
    public static void saveResource(String config_name) {
        new File(WebConfig.plugin.getDataFolder()+File.separator+"/web").mkdirs();
        File configFile = new File(WebConfig.plugin.getDataFolder(), config_name);//获取yml
        if (!configFile.exists()) {//判断有没有yml
            configFile.createNewFile();//创建文件夹
            InputStream is = WebConfig.plugin.getResourceAsStream(config_name);//获取yml
            OutputStream os = Files.newOutputStream(configFile.toPath());//没IQ不会注释
            ByteStreams.copy(is, os);//把jar里的写如到文件夹里的
            os.close();//关闭
            is.close();//关闭
        }
    }

    @SneakyThrows
    public static Configuration getYamlConfiguration(String config_name) {
        ConfigurationProvider provider = YamlConfiguration.getProvider(YamlConfiguration.class);
        return provider.load(new File(WebConfig.plugin.getDataFolder() + "/" + config_name));
    }

}
