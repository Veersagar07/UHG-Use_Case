package com.UHGUseCase.AnnouncementService.Repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UHGUseCase.AnnouncementService.Entity.AnnouncementEntity;

@Repository
public interface AnnouncementRepo extends JpaRepository<AnnouncementEntity, Long>{
	List<AnnouncementEntity> findByEndDateBefore(LocalDateTime endDate);
}
