package com.bstek.dorado.sample.standardlesson.service;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.sample.standardlesson.dao.SlCompanyDao;
import com.bstek.dorado.sample.standardlesson.entity.SlCompany;

@Component
public class CompanyService{
	
    @Resource
    private SlCompanyDao slcompanyDao;
     
    /*
     * @DataProvider与@Expose相似，@DataProvider会自动将当前方法对应的服务，根据一系列约定的规则，
     * 在运行时注册成全局的DataProvider放在DataProviderManager的对象中，
     * 用以对DataSet提供数据加载服务
     */
    @DataProvider
    public Collection<SlCompany> getCompany(){
        return slcompanyDao.getAll();
    }
    
    /*
     * @DataResolver是用于声明这个Java方法为一个DataResolver方法，可以被客户端的DataResolver技术所调用
     * 忘记加入@Transactional注解，带来的结果就是修改的数据无法commit进行持久化
     */
    @DataResolver
    @Transactional
    public void saveCompany(Collection<SlCompany> slcompanys){
        slcompanyDao.persistEntities(slcompanys);
    }
}
