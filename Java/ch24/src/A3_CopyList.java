//
// �����ϱ�
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class A3_CopyList {

	public static void main(String[] args) {
		List<String> src = Arrays.asList("Box", "Apple", "Toy", "Robot");
		
		// ���纻�� ���� ���
		List<String> dest = new ArrayList<>(src);
		
		// �����Ͽ� �� ����� ���
		Collections.sort(dest);
		System.out.println(dest);
		
		// ������ ���� ������ ���·� �ǵ����� ��
		Collections.copy(dest, src);
		
		// �ǵ��� Ȯ��
		System.out.println(dest);
	}
}