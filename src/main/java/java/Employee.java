package java;

import org.apache.commons.lang3.builder.*;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Demo of Equals and HashCode:
 * http://howtodoinjava.com/2012/10/09/working-with-hashcode-and-equals-methods-in-java/
 * http://stackoverflow.com/questions/5038204/apache-commons-equals-hashcode-builder
 */

public class Employee {
    private Integer id;
    
    public Integer getId() {
        return id;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (getClass() != o.getClass()) return false;
        Employee e = (Employee) o;
        //return this.getId() == e.getId();
        return new EqualsBuilder().append(getId(), e.getId()).isEquals();        
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 31;
        return new HashCodeBuilder(getId()%2 == 0? getId() + 1 : getId(), PRIME).toHashCode();
    }
}
