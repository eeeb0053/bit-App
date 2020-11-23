package matrix;

import java.util.Arrays;
import java.util.Scanner;

public class LottoApp {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            LottoDTO instance = new LottoDTO();
            System.out.println("�����ѵ� ����");
            instance.setCountLimit(scanner.nextInt());
            System.out.printf("������ �����ѵ� %d ��\n", instance.getCountLimit());
            while(true) {
                System.out.println("0.���� 1.�ζǱ���");
                switch(scanner.nextInt()) {
                case 0: 
                    System.out.println("����"); 
                    return;
                case 1: 
                    System.out.println("�ζǱ���\n");
                    buyLottos(instance,scanner);
                    break;
                }
            }
        }
        public static void buyLottos(LottoDTO instance,Scanner scanner) {
            System.out.println("��ġ�� �����մϱ�? ");
            System.out.printf("�ζ� %d���� �߱��մϴ�\n");
            int[][] lottos = instance.getLottos();
            for(int i=0; i< lottos.length;i++) {
                for(int j=0; j < lottos[i].length; j++) {
                    System.out.print(lottos[i][j]+"\t");
                }
                System.out.println();
            }
        }
    }
class LottoDTO {
    private int countLimit, lottoCount;
    private int[] lotto;
    private int[][] lottos;
        
    public int getCountLimit() {return countLimit;}
    public void setCountLimit(int countLimit) {this.countLimit = countLimit;}
    public int getLottoCount() {return lottoCount;}
    public int[] getLotto() {return lotto;}
    public void setLotto(int[] lotto) {this.lotto = lotto;}
    public int[][] getLottos() {return lottos;}
    public void setLottos(int[][] lottos) {this.lottos = lottos;}
    @Override
    public String toString() {
        return "LottoDTO [countLimit=" + countLimit + ", lottoCount=" + lottoCount + ", lotto=" + Arrays.toString(lotto)
                + ", lottos=" + Arrays.toString(lottos) + "]";
    }
}
interface LottoService {
}
class LottoServiceImpl implements LottoService{
}
class LottoController {
}