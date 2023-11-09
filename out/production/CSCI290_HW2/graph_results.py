import matplotlib.pyplot as plt
import numpy as np

serial = [0.141, 0.159, 0.156, 0.156]
serial_avg = np.mean(serial)
print(f'serial_avg: {serial_avg}')

explicit_locks = [0.798, 0.935, 0.780, 1.041]
exp_locks_avg = np.mean(explicit_locks)
print(f"exp_locks_avg: {exp_locks_avg}")

synchronized = [0.637, 0.723, 0.719, 0.671]
synchronized_avg = np.mean(synchronized)
print(f"synchronized_avg: {synchronized_avg}")

atomic_int = [0.580, 0.595, 0.582, 0.580]
atomic_int_avg = np.mean(atomic_int)
print(f"atomic_int_avg: {atomic_int_avg}")

# Labels for the bars
labels = ['Serial', 'Explicit Locks', 'Synchronized', 'Atomic Integer']

# The average times
times = [serial_avg, exp_locks_avg, synchronized_avg, atomic_int_avg]

# Create the bar graph
plt.figure(figsize=(10, 6))
plt.bar(labels, times, color=['blue', 'green', 'red', 'purple'])

# Add title and labels
plt.title('Average Execution Time for Different Synchronization Methods')
plt.xlabel('Synchronization Method')
plt.ylabel('Average Time (seconds)')

# Display the graph
plt.show()