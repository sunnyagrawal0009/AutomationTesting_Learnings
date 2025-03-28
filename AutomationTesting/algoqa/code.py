count = 0
for i in range(11):  # Outer loop: i will iterate from 0 to 10
    for j in range(11):  # Inner loop: j will iterate from 0 to 10
        count = count + 1  # Increment count by 1 in each iteration
        if i == 5:  # If i equals 5, break out of the inner loop
            break
print(count)