A simple sample application that displays a list of Product names and allows
one to add new Products.

## Dependencies

  * Docker
  * npm
  * Gradle

## Getting Started

First, start and initialize the Postgresql database:

```bash
docker compose up -d
```

Second, run the React development server:

```bash
npm install
npm run dev
```

Third, run the Java development server:

```bash
./gradlew bootRun --args="--spring.profiles.active=dev"
```

Open [http://localhost:3000](http://localhost:3000) with your browser to see the result.

## Running tests

Backend tests:

```bash
./gradlew test
```

Front-end tests:

```bash
npm run test
```

## Sources

Backend Java sources are in `src/main/java`.  Java tests are in `src/test/java`.

Honoring next.js defaults, Javascript sources are in `src/app`, tests are in
`src/__tests__`.  Mock remote requests are in `src/mocks`.

## Notes

  * The CORS config is dangerously permissive.  Don’t use in production.
  * For simplicity’s sake, I chose not to use an ORM.
  * For the sake of laziness, I hard-coded the jdbc connection string.  It
    really _should_ be in an environment variable.
