//
// �ߺ��� �ν��Ͻ��� ����!
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class C5_ConvertCollection {

	public static void main(String[] args) { // �ߺ��� ����ϴ� ����Ʈ
		List<String> lst = Arrays.asList("Box", "Toy", "Box", "Toy");
		ArrayList<String> list = new ArrayList<>(lst);
		
		for(String s : list)
			System.out.print(s.toString() + '\t');
		System.out.println();
		
		// �ߺ��� �ν��Ͻ��� �ɷ� ���� ���� �۾�
		HashSet<String> set = new HashSet<>(list);
		// �ٸ� �÷��� �ν��Ͻ��κ��� HashSet<E> �ν��Ͻ� ����
		
		// ������� ArryList<String> �ν��Ͻ��� ���幰�� �ű��.
		list = new ArrayList<>(set);
		
		for(String s : list)
			System.out.print(s.toString() + '\t');
		System.out.println();
	}

}
