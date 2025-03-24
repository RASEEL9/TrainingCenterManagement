package com.example.service;

import com.example.entity.Certification;
import com.example.repository.CertificationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificationService {

    private static final Logger logger = LoggerFactory.getLogger(CertificationService.class);

    private final CertificationRepository certificationRepository;
    
   // no need of AutoWierd because we only have one constructor
    public CertificationService(CertificationRepository certificationRepository) {
        this.certificationRepository = certificationRepository;
    }

    public List<Certification> getAllCertifications() {
        logger.info("Fetching all certifications");
        List<Certification> certifications = certificationRepository.findAll();
        logger.info("Retrieved {} certifications", certifications.size());
        return certifications;
    }

    public Optional<Certification> getCertificationById(Long id) {
        logger.info("Fetching certification with id: {}", id);
        Optional<Certification> certification = certificationRepository.findById(id);
        if (certification.isPresent()) {
            logger.info("Certification found with id: {}", id);
        } else {
            logger.warn("Certification not found with id: {}", id);
        }
        return certification;
    }

    public Certification addCertification(Certification certification) {
        logger.info("Adding new certification: {}", certification);
        Certification savedCertification = certificationRepository.save(certification);
        logger.info("Certification added");
        return savedCertification;
    }

    public void deleteCertification(Long id) {
        logger.info("Deleting certification with id: {}", id);
        certificationRepository.deleteById(id);
        logger.info("Certification with id: {} has been deleted", id);
    }
}
