package com.dashboard.dto.response;

import com.dashboard.common.RoleEnum;
import com.dashboard.model.portal.UserAuthorization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class JwtResponse {
    String token;
    Integer id;
    String username;
    Map<String, String> authorizations;
    List<String> role;
}
