package hazelcast;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class User{
    private String name;
    private int age;
    private String address;
}
