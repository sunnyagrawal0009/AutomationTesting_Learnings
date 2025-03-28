class Animal:
    def __init__(self, name):
        self.name = name

    def speak(self):
        print(f"{self.name} makes a sound")

# Derived class (Child Class) inheriting from Animal class
class Dog(Animal):
    def __init__(self, name, breed):
        # Calling the constructor of the parent class (Animal)
        super().__init__(name)
        self.breed = breed

    def bark(self):
        print(f"{self.name} barks!")

# Derived class (Grandchild Class) inheriting from Dog class
class Puppy(Dog):
    def __init__(self, name, breed, age):
        # Calling the constructor of the parent class (Dog)
        super().__init__(name, breed)
        self.age = age

    def play(self):
        print(f"{self.name} is playing!")

# Create an instance of the Puppy class
puppy = Puppy("Buddy", "Golden Retriever", 1)

# Call methods from all classes
puppy.speak()  # Method from Animal class
puppy.bark()   # Method from Dog class
puppy.play()   # Method from Puppy class