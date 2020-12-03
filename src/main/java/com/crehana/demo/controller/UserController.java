package com.crehana.demo.controller;

import com.crehana.demo.model.User;
import com.crehana.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User", description = "API")
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    @Operation(summary = "Get All Users", description = "Get All Users", tags = {"User"})
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @GetMapping("/page")
    @Operation(summary = "Get All Users Page", description = "Get All Users Page", tags = {"User"},
            parameters = {
                    @Parameter(in = ParameterIn.QUERY
                            , description = "Page you want to retrieve (0..N)"
                            , name = "page"
                            , content = @Content(schema = @Schema(type = "integer", defaultValue = "0"))),
                    @Parameter(in = ParameterIn.QUERY
                            , description = "Number of records per page."
                            , name = "size"
                            , content = @Content(schema = @Schema(type = "integer", defaultValue = "20"))),
                    @Parameter(in = ParameterIn.QUERY
                            , description = "Sorting criteria in the format: property(,asc|desc). "
                            + "Default sort order is ascending. " + "Multiple sort criteria are supported."
                            , name = "sort"
                            , content = @Content(array = @ArraySchema(schema = @Schema(type = "string"))))
            })
    public Page<User> getAllUsers(@PageableDefault @Parameter(hidden = true) Pageable pageable){
        return this.userService.getAllUsersPage(pageable);
    }

    @GetMapping("/users/memberships/{memberId}")
    @Operation(summary = "Get All Users by MembershipId", description = "Get All Users by MembershipId", tags = {"User"},
            parameters = {
                    @Parameter(in = ParameterIn.QUERY
                            , description = "Page you want to retrieve (0..N)"
                            , name = "page"
                            , content = @Content(schema = @Schema(type = "integer", defaultValue = "0"))),
                    @Parameter(in = ParameterIn.QUERY
                            , description = "Number of records per page."
                            , name = "size"
                            , content = @Content(schema = @Schema(type = "integer", defaultValue = "20"))),
                    @Parameter(in = ParameterIn.QUERY
                            , description = "Sorting criteria in the format: property(,asc|desc). "
                            + "Default sort order is ascending. " + "Multiple sort criteria are supported."
                            , name = "sort"
                            , content = @Content(array = @ArraySchema(schema = @Schema(type = "string"))))
            })
    public Page<User> getAllUsersByMembershipId(@PathVariable Long memberId, @PageableDefault @Parameter(hidden = true) Pageable pageable){
        return this.userService.getAllUsersByMembershipId(memberId, pageable);
    }

    @GetMapping("/username/{username}")
    @Operation(summary = "Get All Users by Username", description = "Get All Users by Username", tags = {"User"})
    public User getAllUsers(@PathVariable String username){
        return this.userService.getUserByUsername(username);
    }

    @GetMapping("/{userId}")
    @Operation(summary = "Get All Users by Id", description = "Get All Users by Id", tags = {"User"})
    public User getAllUsers(@PathVariable Long userId){
        return this.userService.getUserById(userId);
    }
}
