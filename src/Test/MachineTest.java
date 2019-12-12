package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Machine;
import model.TypeMachines;

class MachineTest {

    @Test
    void test() {
   	 Machine m = new Machine(new TypeMachines(""));
   	 assertEquals(false,m.getUtil());
   	 m.estUtil();
   	 assertEquals(true,m.getUtil());
   	 m.pasUtil();
   	 assertEquals(false,m.getUtil());
    }

}

