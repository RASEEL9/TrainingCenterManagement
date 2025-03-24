package com.example.service;

import com.example.dto.TrainerDTO;
import com.example.entity.Trainer;
import com.example.repository.TrainerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrainerService {

    private static final Logger logger = LoggerFactory.getLogger(TrainerService.class);

    @Autowired
    private TrainerRepository trainerRepository;

    // Get All Trainers
    public List<TrainerDTO> getAllTrainers() {
        logger.info("Fetching all trainers");
        List<TrainerDTO> trainers = trainerRepository.findAll()
                .stream()
                .map(trainer -> new TrainerDTO(
                        trainer.getTrainerId(),
                        trainer.getSubjects(),
                        trainer.getContactInfo(),
                        trainer.getSpecialty()))
                .collect(Collectors.toList());
        logger.info("Fetched {} trainers", trainers.size());
        return trainers;
    }

    //  Get Trainer by ID
    public Optional<TrainerDTO> getTrainerById(Long id) {
        logger.info("Fetching trainer by ID: {}", id);
        Optional<TrainerDTO> trainerDTO = trainerRepository.findById(id)
                .map(trainer -> new TrainerDTO(
                        trainer.getTrainerId(),
                        trainer.getSubjects(),
                        trainer.getContactInfo(),
                        trainer.getSpecialty()));
        if (trainerDTO.isPresent()) {
            logger.info("Found trainer with ID: {}", id);
        } else {
            logger.warn("Trainer with ID {} not found", id);
        }
        return trainerDTO;
    }

    //  Add New Trainer
    public TrainerDTO addTrainer(TrainerDTO trainerDTO) {
        logger.info("Adding new trainer: {}", trainerDTO.getSubjects());
        Trainer trainer = new Trainer();
        trainer.setSubjects(trainerDTO.getSubjects());
        trainer.setContactInfo(trainerDTO.getContactInfo());
        trainer.setSpecialty(trainerDTO.getSpecialty());

        Trainer savedTrainer = trainerRepository.save(trainer);
        logger.info("Saved new trainer with ID: {}", savedTrainer.getTrainerId());
        return new TrainerDTO(savedTrainer.getTrainerId(), savedTrainer.getSubjects(),
                savedTrainer.getContactInfo(), savedTrainer.getSpecialty());
    }

    //  Delete Trainer by ID
    public void deleteTrainer(Long id) {
        logger.info("Deleting trainer with ID: {}", id);
        trainerRepository.deleteById(id);
        logger.info("Deleted trainer with ID: {}", id);
    }
}
