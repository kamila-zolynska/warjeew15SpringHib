package pl.coderslab.dwarfs;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DwarfService {

    private final DwarfDao dwarfDao;

    public List<Dwarf> findAll() {
        return dwarfDao.findDwarfs2();
    }
    public void save(Dwarf dwarf) {
        dwarfDao.save(dwarf);
    }

    public Dwarf findById(Long id) {
        return dwarfDao.findById(id);
    }
}
