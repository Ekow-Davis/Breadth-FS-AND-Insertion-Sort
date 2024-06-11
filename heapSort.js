function heapSort(arr) {
  let n = arr.length;

  // Build a max heap
  for (let i = Math.floor(n / 2) - 1; i >= 0; i--) {
    heapify(arr, n, i);
  }

  // One by one extract elements from heap
  for (let i = n - 1; i > 0; i--) {
    // Move current root to end
    let temp = arr[0];
    arr[0] = arr[i];
    arr[i] = temp;

    // Call max heapify on the reduced heap
    heapify(arr, i, 0);
  }
}

function heapify(arr, length, i) {
  let largest = i;
  let left = i * 2 + 1;
  let right = left + 1; // i * 2 + 2 

  if (left < length && arr[left] > arr[largest]) {
    largest = left;
  }

  if (right < length && arr[right] > arr[largest]) {
    largest = right;
  }

  if (largest !== i) {
    [arr[i], arr[largest]] = [arr[largest], arr[i]];

    heapify(arr, length, largest);
  }

  return arr;
}
