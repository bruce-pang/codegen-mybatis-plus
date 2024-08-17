package com.brucepang.mybatis.core.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.brucepang.mybatis.core.entity.BaseEntity;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Common parameter populates implementation classes
 *
 * If the common parameters are not explicitly assigned, the common parameters will be populated and assigned here
 *
 * @author hexiaowu
 */
public class DefaultDBFieldHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        if (Objects.nonNull(metaObject) && metaObject.getOriginalObject() instanceof BaseEntity) {
            BaseEntity baseEntity = (BaseEntity) metaObject.getOriginalObject();

            LocalDateTime current = LocalDateTime.now();
            // If the creation time is empty, the current time is the insertion time
            if (Objects.isNull(baseEntity.getCreateTime())) {
                baseEntity.setCreateTime(current);
            }
            // If the update time is empty, the current time is the update time
            if (Objects.isNull(baseEntity.getUpdateTime())) {
                baseEntity.setUpdateTime(current);
            }

            // todo: 通过注入Bean获取WebFrameworkUtils,进而获取当前登录用户的ID
            // Long userId = WebFrameworkUtils.getLoginUserId();
            Long userId = 1L;
            // If the current login user is not empty and the creator is empty, the current login user is the creator
            if (Objects.nonNull(userId) && Objects.isNull(baseEntity.getCreator())) {
                baseEntity.setCreator(userId.toString());
            }
            // If the current logged-in user is not empty and the updater is empty, the current logged-in user is the updater
            if (Objects.nonNull(userId) && Objects.isNull(baseEntity.getUpdater())) {
                baseEntity.setUpdater(userId.toString());
            }
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // If the update time is empty, the current time is the update time
        Object modifyTime = getFieldValByName("updateTime", metaObject);
        if (Objects.isNull(modifyTime)) {
            setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        }

        // If the current logged-in user is not empty and the updater is empty, the current logged-in user is the updater
        Object modifier = getFieldValByName("updater", metaObject);
        // todo: 通过注入Bean获取WebFrameworkUtils,进而获取当前登录用户的ID
        // Long userId = WebFrameworkUtils.getLoginUserId();
        Long userId = 1L;
        if (Objects.nonNull(userId) && Objects.isNull(modifier)) {
            setFieldValByName("updater", userId.toString(), metaObject);
        }
    }
}
