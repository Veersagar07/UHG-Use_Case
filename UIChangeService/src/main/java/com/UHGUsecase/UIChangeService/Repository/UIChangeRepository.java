package com.UHGUsecase.UIChangeService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UHGUsecase.UIChangeService.Entity.UIChange;

@Repository
public interface UIChangeRepository extends JpaRepository<UIChange, Integer>{

}
