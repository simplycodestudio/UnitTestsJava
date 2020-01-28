package pl.devfoundry.testing.mockitoHomework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UnitServiceTest {

    @Mock
    UnitRepository unitRepository;
    @Mock
    CargoRepository cargoRepository;

    @InjectMocks
    private UnitService unitService;

    @Test
    void addedCargoShouldBeLoadedOnUnit() {
        Unit unit = new Unit(new Coordinates(0,0), 10, 10);
        Cargo cargo = new Cargo("package", 5);
    }

}