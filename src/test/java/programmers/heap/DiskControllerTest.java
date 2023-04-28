package programmers.heap;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class DiskControllerTest {

    @Test
    void applicationTest() {
        Programmers42627 application = new Programmers42627();

        assertThat(application.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}})).isEqualTo(9);
    }
}
