# Suggested implementation of mandatory dependency

![dependency class diagram](http://www.plantuml.com/plantuml/png/LSin3i8m38NXtQVmZDGU0NLWOUO4bdcq5Kw870Uf0kuEWYLix_tIDzKGZvQCYkXLPl0j5hZ91dyGhpdW5r7m0GNvZAmRiPhKsfLZAaOlel_2OolZSzzB-iaJ_Bugleowmxl1rtc9eJVJPxHaRm00)

<table>
<tr>
<td> Mandatory dependency
  </td> <td> Component (implementation) </td>
</tr>
<tr>
<td> 

```java
@Service
class ServiceImpl {
  
  private final Dependency dependency;
  
  public ServiceImpl(Dependency dependency) {
    this.dependency = dependency;
  }
  
}
```
    
</td>
<td>


```java
@Component
class DependencyImpl implements Dependency {}
```
  
</td>
</tr>
<tr>
<td> 
  
  * managed bean (@Service)
  * dependency is stored in final private field
  * dependency is an interface
  
</td> 
<td> 
  
  * managed bean (@Component)
  * implements the interface
  
</td>
</tr>
</table>



The above implementation provides
* testable code (dependency comes via constructor parameter)
* flexible code
* Spring independent (easy to use without Spring)


# Unit testing

In the case of following scenario

![dependency usage](https://www.planttext.com/api/plantuml/svg/SoWkIImgAStDuU9opiyhAShFIIrIqBLJ24ujAijCJlNCBSYnKaXEp4akpKaiIUL24WQfSaajICrBISrBheGep4ZDAU125LJGHJKDrGYW7DnQBYu7e3wWKm00)

the service use (call the method of dependency).

We would like to test just the service code (without dependency). So we have to mock it.

if the implementation looks like this:

```java
@Service
class ServiceImpl {
  
  private final Dependency dependency;
  
  public ServiceImpl(Dependency dependency) {
    this.dependency = dependency;
  }
  
  public int calculate() {
    int helpValue = dependency.help()
    
    if (helpValue > 0) {
      return helpValue;
    } else {
      return helpValue % 2
    }
  }
}
```

https://www.baeldung.com/mockito-verify
