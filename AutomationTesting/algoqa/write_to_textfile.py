# Writing content to a text file
with open('sample.txt', 'w') as file:
    file.write("Hello, this is a sample text.\n")
    file.write("Python is a great language for automation and development.\n")
    file.write("This is the third line of text.")

# Reading the content from the text file
with open('sample.txt', 'r') as file:
    content = file.read()

# Printing the content read from the file
print("Content of the file:")
print(content)