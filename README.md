# stalkurstock-api

### Informal swagger:

#### GET all symbols:
```https://stalkurstock-api.herokuapp.com/api/symbols```

#### GET info on a symbol e.g FCF:
```https://stalkurstock-api.herokuapp.com/api/symbols/FCF```

#### GET quote of a symbol e.g FCF:
```https://stalkurstock-api.herokuapp.com/api/quote?symbol=FCF```

### Docker commands:

##### To build the image:
```docker build -t stalkurstock/stalkurstock-api .```

##### Run the image with env file:
```docker run -p 8081:8081 --env-file ./env.list stalkurstock/stalkurstock-api```

_NOTE: Currently only supporting US based exchanges. Moreover, the test DB only contains 500 symbols due to free tier constraints._