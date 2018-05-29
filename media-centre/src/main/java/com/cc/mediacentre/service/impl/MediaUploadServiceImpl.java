package com.cc.mediacentre.service.impl;

import com.cc.mediacentre.common.CCEnum;
import com.cc.mediacentre.dao.MediaFileRepository;
import com.cc.mediacentre.dto.MediaFileDTO;
import com.cc.mediacentre.entity.EnvProperties;
import com.cc.mediacentre.entity.MediaFileEntity;
import com.cc.mediacentre.service.FileService;
import com.cc.mediacentre.service.MediaUploadService;
import com.cc.mediacentre.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MediaUploadServiceImpl implements MediaUploadService{
    @Autowired
    private MediaFileRepository mediaFileRepository;

    @Autowired
    private FileService fileService;

    @Autowired
    private EnvProperties envProperties;


    @Override
    public String mdkFile(MediaFileDTO dto) {
        MediaFileEntity fileEntity = createSplitMediaFile(dto);
        return fileEntity.getUuid();
    }


    @Override
    public boolean splitUpload(MediaFileDTO dto) {
        return fileService.saveSlipFile(dto.getFile(), envProperties.getTbdDirPathPath(), dto.getUuid(), dto.getSlice());
    }

    @Override
    public Integer upload(MediaFileDTO dto) {
        if (dto.getFile().isEmpty()) {
            return 0;
        }
        MediaFileEntity fileEntity = createMediaFile(dto);
        boolean s = fileService.saveFile(dto.getFile(), fileEntity.getPath(), fileEntity.getUuid());
        if (!s) {
            return 0;
        }
        return 1;
    }


    @Override
    public boolean merge(String uuid) {
        boolean b = false;
        MediaFileEntity fileEntity = mediaFileRepository.findById(uuid).get();
        if (null != fileEntity) {
            b = fileService.slipMerge(fileEntity.getPath(), fileEntity.getUuid());
            if (b) {
                fileEntity.setStatus(CCEnum.BillStatus.NEW_ADD.getCode());
                mediaFileRepository.saveAndFlush(fileEntity);
            }
        }
        return b;
    }

    MediaFileEntity createMediaFile(MediaFileDTO dto) {
        String fileName = dto.getFile().getOriginalFilename();
        String type = dto.getFile().getOriginalFilename().substring(fileName.lastIndexOf(".") + 1, fileName.length());
        String path = CommonUtils.getDatePath();
        Long size = dto.getFile().getSize();
        return saveMediaFile(fileName, path, type, size, 1, CCEnum.BillStatus.NEW_ADD.getCode());
    }

    MediaFileEntity createSplitMediaFile(MediaFileDTO dto) {
       return saveMediaFile(dto.getName(), envProperties.getTbdDirPathPath(), dto.getType(), dto.getSize(), 1, CCEnum.BillStatus.DISABLED.getCode());
    }



    MediaFileEntity saveMediaFile(String name,String path, String type, Long size,Integer createBy, Integer status) {
        MediaFileEntity fileEntity = new MediaFileEntity();
        fileEntity.setName(name);
        fileEntity.setPath(path);
        fileEntity.setType(type);
        fileEntity.setSize(size);
        fileEntity.setCreateBy(createBy);
        fileEntity.setStatus(status);
        fileEntity.setCreateTime(new Date());
        mediaFileRepository.saveAndFlush(fileEntity);
        return fileEntity;
    }


}
