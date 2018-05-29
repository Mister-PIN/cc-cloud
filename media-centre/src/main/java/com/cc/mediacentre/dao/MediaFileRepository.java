package com.cc.mediacentre.dao;

import com.cc.mediacentre.entity.MediaFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MediaFileRepository extends JpaRepository<MediaFileEntity, String>{

    @Override
    MediaFileEntity saveAndFlush(MediaFileEntity entity);

    @Override
    Optional<MediaFileEntity> findById(String uuid);
}
