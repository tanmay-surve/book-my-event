import com.tanmay.tickets.config.CustomJwtAuthenticationConverter;
import com.tanmay.tickets.filters.UserProvisioningFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.web.authentication.BearerTokenAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;

@Bean
public SecurityFilterChain filterChain(
        HttpSecurity http,
        UserProvisioningFilter userProvisioningFilter,
        CustomJwtAuthenticationConverter customJwtAuthenticationConverter) throws Exception {

  http
          .authorizeHttpRequests(authorize ->
                  authorize
                          .requestMatchers(HttpMethod.GET, "/api/v1/published-events/**").permitAll()
                          .requestMatchers("/api/v1/events").hasRole("ORGANIZER")
                          .anyRequest().authenticated())
          .csrf(csrf -> csrf.disable())
          .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
          .oauth2ResourceServer(oauth2 ->
                  oauth2.jwt(jwt ->
                          jwt.jwtAuthenticationConverter(customJwtAuthenticationConverter)
                  ))
          .addFilterAfter(userProvisioningFilter, BearerTokenAuthenticationFilter.class);

  return http.build();
}

void main() {
}
