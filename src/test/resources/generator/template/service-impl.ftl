package ${featurePackage}.${modelPackage}.service.impl;

import ${featurePackage}.${modelPackage}.mapper.${modelNameUpperCamel}Mapper;
import ${featurePackage}.${modelPackage}.model.${modelNameUpperCamel};
import ${featurePackage}.${modelPackage}.service.${modelNameUpperCamel}Service;
import ${basePackage}.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by ${author} on ${date}.
 */
@Service
@Transactional
public class ${modelNameUpperCamel}ServiceImpl extends AbstractService<${modelNameUpperCamel}> implements ${modelNameUpperCamel}Service {
    @Resource
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;

}
