package ${basePackage}.${modelPackage}.service.impl;

import ${basePackage}.${modelPackage}.mapper.${modelNameUpperCamel}Mapper;
import ${basePackage}.${modelPackage}.model.${modelNameUpperCamel};
import ${basePackage}.${modelPackage}.service.${modelNameUpperCamel}Service;
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
