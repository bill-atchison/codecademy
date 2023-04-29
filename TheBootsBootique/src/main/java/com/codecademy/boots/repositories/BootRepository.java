package com.codecademy.boots.repositories;

import com.codecademy.boots.enums.BootType;
import org.springframework.data.repository.CrudRepository;

import com.codecademy.boots.entities.Boot;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BootRepository extends CrudRepository<Boot, Integer> {
    List<Boot> findByMaterialAndTypeAndSizeAndQuantityLessThan(String material, BootType type, Float size, Integer quantity);
    List<Boot> findByMaterialAndTypeAndSize(String material, BootType type, Float size);
    List<Boot> findByMaterialAndTypeAndQuantityLessThan(String material, BootType type, Integer quantity);
    List<Boot> findByMaterialAndType(String material, BootType type);
    List<Boot> findByMaterial(String material);
    List<Boot> findByTypeAndSizeAndQuantityLessThan(BootType type, Float size, Integer quantity);
    List<Boot> findByTypeAndSize(BootType type, Float size);
    List<Boot> findByTypeAndQuantityLessThan(BootType type, Integer quantity);
    List<Boot> findByType(BootType type);
    List<Boot> findBySizeAndQuantityLessThan(Float size, Integer quantity);
    List<Boot> findBySize(Float size);
    List<Boot> findByQuantityLessThan(Integer quantity);
}