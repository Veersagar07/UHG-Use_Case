package com.AnnouncementService.Repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.AnnouncementService.Entity.AnnouncementEntity;

public interface AnnouncementRepository extends JpaRepository<AnnouncementEntity, Integer> {
	List<AnnouncementEntity> findByEndTimeBefore(LocalDateTime endTime);
}
