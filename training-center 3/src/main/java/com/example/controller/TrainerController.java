package com.example.controller;

import com.example.dto.TrainerDTO;
import com.example.service.TrainerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainers")
public class TrainerController {

    private static final Logger logger = LoggerFactory.getLogger(TrainerController.class);

    @Autowired
    private TrainerService trainerService;

    @GetMapping
    public ResponseEntity<List<TrainerDTO>> getAllTrainers() {
        logger.info("Fetching all trainers.");
        List<TrainerDTO> trainers = trainerService.getAllTrainers();
        logger.info("Fetched {} trainers.", trainers.size());
        return ResponseEntity.ok(trainers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainerDTO> getTrainerById(@PathVariable Long id) {
        logger.info("Fetching trainer with id: {}", id);
        return trainerService.getTrainerById(id)
                .map(trainer -> {
                    logger.info("Trainer found with id: {}", id);
                    return ResponseEntity.ok(trainer);
                })
                .orElseGet(() -> {
                    logger.warn("Trainer not found with id: {}", id);
                    return ResponseEntity.notFound().build();
                });
    }

    @PostMapping
    public ResponseEntity<TrainerDTO> addTrainer(@RequestBody TrainerDTO trainerDTO) {
        logger.info("Adding new trainer: {}", trainerDTO);
        TrainerDTO createdTrainer = trainerService.addTrainer(trainerDTO);
        logger.info("Trainer added with id: {}", createdTrainer.getTrainerId());
        return ResponseEntity.ok(createdTrainer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrainer(@PathVariable Long id) {
        logger.info("Deleting trainer with id: {}", id);
        trainerService.deleteTrainer(id);
        logger.info("Trainer with id: {} deleted successfully.", id);
        return ResponseEntity.noContent().build();
    }
}
