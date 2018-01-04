package com.bstek.dorado.sample.standardlesson.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.springframework.stereotype.Component;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.core.DoradoAbout;

/*
 * @Expose标记是Dorado7专门提供的标注，用于定义可暴露服务，
 * 根据这个规则Dorado7会将这个方法自动注册在 ExposedServiceManager中，其中服务名为：systemInfoService，
 * 服务表达式 为:systemInfoService#getSystemInfo。
 * 服务名就是SystemInfoService.java在BeanFactory中注册的bean的id,
 * annotation机制会自动将Ajax的S自动转换为小写字母。
 * 
 */
@Component
public class  SystemInfoService {
	
    @Expose
    public Properties getSystemInfo() {
        Properties info = new Properties();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
        info.setProperty("product", DoradoAbout.getProductTitle());
        info.setProperty("vendor", DoradoAbout.getVendor());
        info.setProperty("version", DoradoAbout.getVersion());
        info.setProperty("time", sdf.format(new Date()));
        return info;
    }
}
