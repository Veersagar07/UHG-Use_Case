package com.UHGUsecase.UIChangeService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UHGUsecase.UIChangeService.Entity.UIChange;
import com.UHGUsecase.UIChangeService.Repository.UIChangeRepository;

@Service
public class UIChangeService {

	@Autowired
	private UIChangeRepository uiChangeRepository;

	public UIChange setPosition(UIChange position) {
		Optional<UIChange> uiPosition = uiChangeRepository.findById(position.getId());
		if (uiPosition.isEmpty()) {
			return uiChangeRepository.save(position);
		}
		UIChange savedPosition = uiPosition.get();
		savedPosition.setPosition(position.getPosition());
		return uiChangeRepository.save(savedPosition);
	}

	public List<UIChange> getPositions() {
		return uiChangeRepository.findAll();
	}

}
