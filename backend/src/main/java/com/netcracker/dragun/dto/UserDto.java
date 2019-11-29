package com.netcracker.dragun.dto;

        import lombok.AllArgsConstructor;
        import lombok.Builder;
        import lombok.Data;
        import lombok.ToString;

@AllArgsConstructor
@Data
@Builder
@ToString
public class UserDto {
    private Long id;
    private String name;
    private String lastName;
    private String login;
    private String password;
    private String role;
}
