# spring-security-cors

[![Join the chat at https://github.com/arpitaggarwal/spring-security-cors](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/arpitaggarwal/spring-security-cors?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Build Status](https://api.travis-ci.org/arpitaggarwal/spring-security-cors.svg?branch=master)](https://travis-ci.org/arpitaggarwal/spring-security-cors)

### Download Vega

 - https://subgraph.com/vega/

### Problem

Vega has detected that the resource has set an insecure Cross-Origin Resource Sharing (CORS) access control. CORS provides mechanisms that allow a server to restrict resource access for cross-site requests to certain trusted domains. The server in question has allowed resource from any origin by setting the value of the "Access-Control-Allow-Origin" response header to a wildcard value. This presents a security risk because any site can issue requests to access resources, regardless of origin.

### Remediation

Set the "Access-Control-Allow-Origin" response header to allow access from trusted domains only. Do not allow access from arbitrary domains.

```
    HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Methods",
				"POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
```
