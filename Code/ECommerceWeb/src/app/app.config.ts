import { ApplicationConfig } from '@angular/core';
import {
  provideRouter,
  withEnabledBlockingInitialNavigation,
} from '@angular/router';
import { appRoutes } from './app.routes';

export const appConfig: ApplicationConfig = {
  providers: [provideRouter(appRoutes, withEnabledBlockingInitialNavigation())],
};

export const environment = {
  production: false,
  apiBaseUrl: (window as { [key: string]: any })["env"]["apiUrl"],
  debug: (window as { [key: string]: any })["env"]["debug"] || false
};
