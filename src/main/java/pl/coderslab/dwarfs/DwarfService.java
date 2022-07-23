package pl.coderslab.dwarfs;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DwarfService {

    private final DwarfDao dwarfDao;

    public void save(Dwarf dwarf) {
        dwarfDao.save(dwarf);
    }

    public Dwarf findById(Long id) {
        return dwarfDao.findById(id);
    }
}
