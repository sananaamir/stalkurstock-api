# stalkurstock-api

### Informal swagger:

#### GET all symbols:
```https://stalkurstock-api.herokuapp.com/api/symbols```

#### GET info on a symbol e.g FCF:
```https://stalkurstock-api.herokuapp.com/api/symbols/FCF```

#### GET quote of a symbol e.g FCF:
```https://stalkurstock-api.herokuapp.com/api/quote?symbol=FCF```

_NOTE: Currently only supporting US based exchanges. Moreover, the test DB only contains 500 symbols due to free tier constraints._