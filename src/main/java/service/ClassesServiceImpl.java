package service;

import model.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import repository.ClassRepository;

import java.util.Optional;

@Service
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassRepository classRepository;

    @Override
    public Iterable<Classes> findAll() {
        return classRepository.findAll();
    }

    @Override
    public Optional<Classes> findById(Long id) {
        return classRepository.findById(id);
    }

    @Override
    public void save(Classes classes) {
        classRepository.save(classes);
    }

    @Override
    public void remove(Long id) {
        classRepository.deleteById(id);
    }
}
