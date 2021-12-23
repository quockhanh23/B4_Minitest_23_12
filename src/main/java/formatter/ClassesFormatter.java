package formatter;

import model.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import service.ClassesServiceImpl;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class ClassesFormatter implements Formatter<Classes> {
    private ClassesServiceImpl classesService;

    @Autowired
    public ClassesFormatter(ClassesServiceImpl classesService) {
        this.classesService = classesService;
    }

    @Override
    public Classes parse(String text, Locale locale) throws ParseException {
        Optional<Classes> classesOptional = classesService.findById(Long.parseLong(text));
        return classesOptional.orElse(null);
    }

    @Override
    public String print(Classes object, Locale locale) {
        return "[" + object.getId() + ", " + object.getName() + "]";
    }
}
