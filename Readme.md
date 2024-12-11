# ipapi-java

A Java library to query IP addresses using the [ipquery.io](https://ipquery.io) API.

## Features

- Query details for a specific IP address.
- Bulk query multiple IP addresses.
- Fetch your own public IP address.

## Installation

To use this library, clone the repository and build it using Gradle.

### Prerequisites

- JDK 8 or later
- Gradle (if not installed, use the Gradle wrapper)

### Clone the Repository

```bash
git clone https://github.com/your-username/ipapi-java.git
cd ipapi-java
```

### Build and Install Dependencies

To build the project and install dependencies, use the following Gradle command:

```bash
./gradlew build
```

This will download the required dependencies, compile the source code, and generate a JAR file in the `build/libs/` directory.

## Usage

### Query a Specific IP Address

The `queryIp` method retrieves information about a specific IP address, including its ISP, location, and risk data.

```java
import io.ipapi.IPInfo;
import io.ipapi.Ipapi;

public class Main {
    public static void main(String[] args) {
        Ipapi ipapi = new Ipapi("YOUR_API_KEY"); // Replace with your API key
        IPInfo ipInfo = ipapi.queryIp("8.8.8.8");

        if (ipInfo != null) {
            System.out.println(ipInfo);
        } else {
            System.out.println("Failed to fetch IP information.");
        }
    }
}
```

#### Output Example
```plaintext
IPInfo {
    ip: "8.8.8.8",
    isp: { asn: "AS15169", org: "Google LLC", isp: "Google LLC" },
    location: {
        country: "United States",
        country_code: "US",
        city: "Mountain View",
        state: "California",
        zipcode: "94043",
        latitude: 37.436,
        longitude: -122.0938,
        timezone: "America/Los_Angeles",
        localtime: "2024-12-11T18:26:48"
    },
    risk: {
        is_mobile: false,
        is_vpn: false,
        is_tor: false,
        is_proxy: false,
        is_datacenter: true,
        risk_score: 0
    }
}
```

### Bulk Query Multiple IP Addresses

The `queryBulk` method allows you to query information for multiple IP addresses at once.

```java
import io.ipapi.Ipapi;

public class Main {
    public static void main(String[] args) {
        Ipapi ipapi = new Ipapi("YOUR_API_KEY"); // Replace with your API key
        List<String> ips = Arrays.asList("8.8.8.8", "1.1.1.1");

        List<IPInfo> ipInfos = ipapi.queryBulk(ips);
        for (IPInfo info : ipInfos) {
            System.out.println(info);
        }
    }
}
```

#### Output Example
```plaintext
IPInfo {
    ip: "8.8.8.8",
    ...
}
IPInfo {
    ip: "1.1.1.1",
    ...
}
```

### Fetch Your Own Public IP Address

The `queryOwnIp` method retrieves the public IP address of the current machine.

```java
import io.ipapi.Ipapi;

public class Main {
    public static void main(String[] args) {
        Ipapi ipapi = new Ipapi("YOUR_API_KEY"); // Replace with your API key
        String ip = ipapi.queryOwnIp();

        if (ip != null) {
            System.out.println("Your IP Address: " + ip);
        } else {
            System.out.println("Failed to fetch public IP address.");
        }
    }
}
```

#### Output Example
```plaintext
Your IP Address: 203.0.113.45
```

## API Documentation

### 1. `queryIp`

#### Signature
```java
public IPInfo queryIp(String ip);
```

#### Description
Fetches detailed information about a specific IP address, including its ISP, location, and risk information.

#### Parameters
- `ip`: A `String` representing the IP address to query.

#### Returns
- An `IPInfo` object containing details about the IP address on success.
- `null` if the network request fails.

---

### 2. `queryBulk`

#### Signature
```java
public List<IPInfo> queryBulk(List<String> ips);
```

#### Description
Fetches information for multiple IP addresses at once. Useful for batch processing.

#### Parameters
- `ips`: A `List<String>` containing the list of IP addresses to query.

#### Returns
- A `List<IPInfo>` containing details for each IP address.

---

### 3. `queryOwnIp`

#### Signature
```java
public String queryOwnIp();
```

#### Description
Fetches the public IP address of the current machine.

#### Returns
- A `String` containing the public IP address on success.
- `null` if the network request fails.

---

## Running Tests

To run tests for this library, use Gradle's test task:

```bash
# Run tests
./gradlew test
```

Gradle will run the tests and show the results in the terminal. You can also view the test results in the `build/reports/tests/test/index.html` file.

## Contributing

Contributions are welcome! Feel free to open issues or submit pull requests on the [GitHub repository](https://github.com/rezwanahmedsami/ipapi-java).