import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class LionTest {

    private Feline feline;
    private String sex;
    private boolean expectedMane;

    public LionTest(String sex, boolean expectedMane) {
        this.sex = sex;
        this.expectedMane = expectedMane;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][] {
                { "Самец", true },
                { "Самка", false }
        });
    }

    @Before
    public void setUp() throws Exception {
        feline = Mockito.mock(Feline.class);
    }

    @Test
    public void testLionDoesHaveMane() throws Exception {
        Lion lion = new Lion(sex, feline);

        assertEquals(expectedMane, lion.doesHaveMane());
    }

    @Test
    public void testLionGetKittens() {
        when(feline.getKittens()).thenReturn(3);

        Lion lion = new Lion(sex, feline);
        assertEquals(3, lion.getKittens());
    }

    @Test
    public void testLionGetFood() throws Exception {
        List<String> food = Arrays.asList("Зебра", "Кролик", "Кабан");
        when(feline.eatMeat()).thenReturn(food);

        Lion lion = new Lion(sex, feline);
        assertEquals(food, lion.getFood());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLionThrowsExceptionForInvalidSex() {
        new Lion("Неизвестно", feline);
    }
}
