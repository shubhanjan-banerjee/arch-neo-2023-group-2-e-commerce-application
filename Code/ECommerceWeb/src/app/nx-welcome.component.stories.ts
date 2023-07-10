import { Meta } from '@storybook/angular';
import { NxWelcomeComponent } from './nx-welcome.component';

export default {
  title: 'NxWelcomeComponent',
  component: NxWelcomeComponent,
} as Meta<NxWelcomeComponent>;

export const Primary = {
  render: (args: NxWelcomeComponent) => ({
    props: args,
  }),
  args: {},
};
