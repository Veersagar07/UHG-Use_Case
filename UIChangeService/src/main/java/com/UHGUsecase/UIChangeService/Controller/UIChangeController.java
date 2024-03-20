package com.UHGUsecase.UIChangeService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UHGUsecase.UIChangeService.Entity.UIChange;
import com.UHGUsecase.UIChangeService.Service.UIChangeService;

@CrossOrigin("*")
@RestController
@RequestMapping("ui")
public class UIChangeController {

	@Autowired
	private UIChangeService uiChangeService;

	@GetMapping
	public ResponseEntity<List<UIChange>> getUIPositions() {
		return ResponseEntity.ok(uiChangeService.getPositions());
	}

	@PutMapping
	public ResponseEntity<Void> updatePositions(@RequestBody UIChange position) {
		uiChangeService.setPosition(position);
		return ResponseEntity.ok().build();
	}

}
