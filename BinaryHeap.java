import java.lang.reflect.Array;
import java.util.Objects;

public class BinaryHeap {
	private int arr[] = new int[10];
	private int size = 0;

	public int remove() {
		int priority = arr[0];
		arr[0] = arr[size-1];
		--size;
		shiftdown(0);
		return priority;
	}

    private void growarr() {
        int newArr[] = new int[arr.length*2];
        for (int i = 0; i < size; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

	public void add(int pri) {
	    if (arr.length == size)
        {
            growarr();
        }
		arr[size] = pri;
		size++;
		int item = size - 1;
		while (item > 0) {
			int parent = (item - 1) / 2;
			if (arr[item] < arr[parent]) {
				swap(arr, item, parent);
				item = parent;
			} else {
				return;
			}
		}
	}

	public void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public void shiftdown(int index) {
		int child = index * 2 + 1;
        if (child >= size)
        {
            return;
        }
		if (arr[child + 1] < arr[child])
			child = child + 1;
		if (arr[index] > arr[child]) {
			swap(arr, index, child);
			shiftdown(child);
		}
	}
}